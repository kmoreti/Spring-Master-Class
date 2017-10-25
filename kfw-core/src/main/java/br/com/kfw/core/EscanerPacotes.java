package br.com.kfw.core;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.kfw.annotations.Componente;

public class EscanerPacotes {

	private static final String SEPARADOR_DIRETORIO = "/";
	private static final String SEPARADOR_PACOTE = "\\.";

	public List<Class<?>> listarClasses(String pacote) throws IOException, URISyntaxException {

		URL urlPacote = Thread.currentThread().getContextClassLoader().getResource(pacoteParaDiretorio(pacote));
		Path pathPacote = Paths.get(urlPacote.toURI());
		List<Path> diretorios = Files.walk(pathPacote).filter(Files::isDirectory).collect(Collectors.toList());
		List<Class<?>> classes = new ArrayList<>();

		for (Path diretorio : diretorios) {
			String caminhoRelativo = pathPacote.relativize(diretorio).toString();
			String auxPacote = pacote;

			if (!caminhoRelativo.isEmpty()) {
				auxPacote = auxPacote.concat(".").concat(caminhoRelativo.toString());
			}

			System.out.printf("Escaneando pacote [%s]\n", auxPacote);

			List<Path> arquivos = Files.list(diretorio)
					.filter(a -> Files.isRegularFile(a) && a.toString().endsWith(".class"))
					.collect(Collectors.toList());

			for (Path arquivo : arquivos) {
				String nomeArquivoClass = auxPacote.concat(".").concat(arquivo.getFileName().toString()).replaceAll(".class", "");

				try {
					Class<?> clazz = Class.forName(nomeArquivoClass);
					System.out.printf("Encontrou a classe [%s]\n", nomeArquivoClass);
					classes.add(clazz);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}

		}

		return classes;
	}

	private String pacoteParaDiretorio(String pacote) {
		pacote = pacote.replaceAll(SEPARADOR_PACOTE, SEPARADOR_DIRETORIO);
		return pacote;
	}

	public List<Class<?>> listarClassesGerenciadas(String pacote) throws IOException, URISyntaxException {
		List<Class<?>> classes = listarClasses(pacote);
		
		classes = classes.stream().filter(c -> c.isAnnotationPresent(Componente.class)).collect(Collectors.toList());
		
		return classes;
	}

}
