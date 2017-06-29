package br.com.jgle.acti.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

import org.apache.log4j.Logger;

public class ArquivoUtil {

	protected static Logger log = Logger.getLogger(ArquivoUtil.class);

	public static void alterarArquivo(String canonicalPathOrigem, String canonicalPathDestino) throws IOException {

		File fl = new File(canonicalPathOrigem);

		if (!fl.exists()) {

			throw new FilerException("Arquivo não encontrado!");
		}

		fl.renameTo(new File(canonicalPathDestino));
		// fl.delete();
		fl = new File(canonicalPathDestino);
		fl.createNewFile();

		log.info("\nNovo Nome :\t" + "  " + fl.getPath());
		log.info("Nome do arquivo :" + fl.getName());
		log.info("Propriedades de :\t" + fl.getPath());
		log.info("Leitura permitida :\t" + fl.canRead());
		log.info("Escrita permitida :\t" + fl.canWrite());
		log.info("Diretorio ? :\t\t" + fl.isDirectory());
		log.info("Arquivo ? :\t\t" + fl.isFile());
	}

	public static void copiarArquivo(String srFile, String dtFile) throws IOException {
		File f1 = new File(srFile);
		File f2 = new File(dtFile);
		InputStream in = new FileInputStream(f1);

		OutputStream out = new FileOutputStream(f2);

		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();

		log.info("Arquivo Copiado");
	}

	public static boolean copiarArquivo(String srFile, String dtDir, String dtFile) throws IOException {
		boolean arquivoCopiadoComSucesso =false;
		try {

			File f1 = new File(srFile);

			File dirDest = new File(dtDir);
			if (!dirDest.exists()){

				boolean foiPossivelCriarDiretorio = dirDest.mkdir();
				if (!foiPossivelCriarDiretorio){

					log.error("Nao foi possivel criar o diretorio:"+dirDest.getCanonicalPath());
					return false;
				}
				else
					log.info("Criado o diretorio:"+dirDest.getCanonicalPath());

			}

			File f2 = new File(dirDest +"/"+dtFile);
			InputStream in = new FileInputStream(f1);

			OutputStream out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();

			log.info("Arquivo Copiado");
			arquivoCopiadoComSucesso = true;
		} catch (Exception e) {
			//			e.printStackTrace();
			log.error("Nao foi possivel gravar o arquivo");
			log.error(e);
		}

		return arquivoCopiadoComSucesso ;
	}

	public static String readFile(String fileName) throws IOException {
		StringBuilder builder = new StringBuilder();
		File file = new File(fileName);
		FileReader reader = new FileReader(file);
		BufferedReader in = new BufferedReader(reader);
		String string;
		while ((string = in.readLine()) != null) {
			builder.append(string);
		}
		in.close();

		return builder.toString();
	}

	public static String ler(String fileName) {
		StringBuilder builder = new StringBuilder();
		try {
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {

				builder.append(scanner.nextLine()).append("\n");
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	public static boolean salvar(String conteudo) throws IOException {
		// Create file
		String arquivo = "gaudi_" + new Date().getTime() + ".txt";
		FileWriter fstream = new FileWriter(arquivo);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(conteudo);
		// Close the output stream
		out.close();

		return true;
	}

	public static void main(String[] args) throws Exception {


		String srFile ="/tmp/genapslinhaecircuitodelinha.zip";

		//		String dtDir ="/tmp/diretorioTeste";
		String dtDir ="/tmp/diretorioTeste/pasta";
		String dtFile ="arquivoTesteRoot.zip";

		System.out.println( ArquivoUtil.copiarArquivo(srFile, dtDir, dtFile) );
	}


	public static boolean criarArquivo(byte[] conteudoArquivo , String nomeArquivo , String dirArquivo){

		FileOutputStream fos = null;
		try {

			File dirDest = new File(dirArquivo);
			if (!dirDest.exists()){
				if(!dirDest.mkdir()){
					log.error("Diretório nao criado em " + dirArquivo);
					return false;
				}
			}
			fos = new FileOutputStream(new File(dirDest,nomeArquivo));
			fos.write(conteudoArquivo);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			log.error(e);
			return false;
		} catch (IOException e) {
			log.error(e);
			return false;
		}
		return true;
	}


	public static InputStream lerArquivo(String dirArquivo,String nomeArquivo){
		try {
			InputStream is = new FileInputStream(dirArquivo+nomeArquivo);
			///is.close();
			return is;
		} catch (FileNotFoundException e) {
			log.error(e);
		} /*catch (IOException e) {
			log.error(e);
		}*/
		return null;
	}
	
	
	public static void lerArquivoClose(String dirArquivo,String nomeArquivo){
		try {
			InputStream is = new FileInputStream(dirArquivo+nomeArquivo);
			is.close();
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

	
	public static void excluirArquivo(String dirArquivo,String nomeArquivo){

		lerArquivoClose(dirArquivo,nomeArquivo);
		
		File f =  new File(dirArquivo,nomeArquivo);
		if(f!= null)
			if(!f.delete())
			log.error("Arquivo nao excluido " + dirArquivo + nomeArquivo);

	}
	
	/** Loads a properties instance based on the data at the incoming config location.
	 *
	 * @param path The path representing the config location.
	 * @return The loaded properties instance.
	 * @throws IOException Unable to load properties from that resource.
	 */
	public static final Properties getConfigProperties(String path) throws IOException{
		
		log.info("load properties from specified config file: " + path);
		
		try {
			Properties properties = (Properties)ReflectionUtil.getInstance("java.util.Properties");
			properties.load( getResourceAsStream(path) );
			return properties;
		}catch(IOException e) {
			throw new IOException("Unable to load properties from specified config file: " + path, e);
		}
	}


	public static InputStream getResourceAsStream(String resource) throws FileNotFoundException {

		log.info("load resource file: " + resource);
		
		String stripped = resource.startsWith("/") ? resource.substring(1) : resource;

		InputStream stream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader!=null) {
			stream = classLoader.getResourceAsStream( stripped );
		}
		if(stream == null)throw new FileNotFoundException( resource + " not found" );
		return stream;
	}
	
	
}
