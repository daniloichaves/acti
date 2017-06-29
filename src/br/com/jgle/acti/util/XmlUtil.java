package br.com.jgle.acti.util;

import java.util.Stack;

public class XmlUtil {

	public static String removeXmlElements(String xml) {
		if (xml != null) {
			return xml.replaceAll("\\</?[A-Za-z]+\\b[^>]*\\>", "");
		}
		return null;
	}

	public static String removeFromXml(String xmlContent, String tag) {
		if (xmlContent != null) {
			StringBuilder builder = new StringBuilder(xmlContent);

			// Procurando pelo inicio da tag
			int idxImgStart = builder.indexOf("<" + tag);
			if (idxImgStart != -1) {
				int idxImgEnd = builder.indexOf(">", idxImgStart);
				if (idxImgEnd != -1) {
					builder.delete(idxImgStart, idxImgEnd + 1);
				}
			}

			// Procurando pelo fim da tag
			idxImgStart = builder.indexOf("<tag");
			if (idxImgStart != -1) {
				int idxImgEnd = builder.indexOf(">", idxImgStart);
				if (idxImgEnd != -1) {
					builder.delete(idxImgStart, idxImgEnd + 1);
				}
			}

			return builder.toString();
		}
		return xmlContent;
	}

	public static String replaceTagFromXml(String xmlContent,
			String tagToBeReplaced, String contentToBeInserted) {
		if (xmlContent == null) {
			return xmlContent;
		}

		StringBuilder builder = new StringBuilder(xmlContent);

		// Procurando pelo inicio da tag
		int idxImgStart = builder.indexOf("<" + tagToBeReplaced);
		while (idxImgStart != -1) {
			int idxImgEnd = builder.indexOf(">", idxImgStart);
			if (idxImgEnd != -1) {
				builder.delete(idxImgStart, idxImgEnd + 1);
				builder.insert(idxImgStart, contentToBeInserted);
			}
			idxImgStart = builder.indexOf("<" + tagToBeReplaced, idxImgStart);
		}

		return builder.toString();
	}

	public static String extractFirstTagFromXml(String xmlContent, String tag) {
		// Procurando pelo inicio da tag
		String saida = null;
		int idxImgStart = xmlContent.indexOf("<" + tag);
		if (idxImgStart != -1) {
			int idxImgEnd = xmlContent.indexOf(">", idxImgStart);
			if (idxImgEnd != -1) {
				saida = xmlContent.substring(idxImgStart, idxImgEnd + 1);
				if (!saida.endsWith("/>")) {
					saida += "</" + tag + ">";
				}
			}
		}
		return saida;
	}
	
	public static String extractValueFromFirstTagFromXml(String xmlContent, String tag) {
		// Procurando pelo inicio da tag
		String saida = null;
		int idxImgStart = xmlContent.indexOf("<" + tag);
		if (idxImgStart != -1) {
			int idxImgEnd = xmlContent.indexOf("/" + tag + ">", idxImgStart);
			if (idxImgEnd != -1) {
				saida = xmlContent.substring(idxImgStart + tag.length() + 2, idxImgEnd - 1);
			}
		}
		return saida;
	}

	public static String extractAttributeValueFromXml(String tag,
			String attribute) {
		// Procurando pelo inicio da tag
		String saida = null;
		String start = attribute + "=\"";
		int idxImgStart = tag.indexOf(start);
		if (idxImgStart != -1) {
			int idxImgEnd = tag.indexOf("\"", idxImgStart + start.length());
			if (idxImgEnd != -1) {
				saida = tag.substring(idxImgStart + start.length(), idxImgEnd);
			}
		}
		return saida;
	}

	/**
	 * Diminuir a quantidade de caracteres mantendo as TAGs XML. Dessa forma
	 * podemos diminuir o conteudo de textos sem atrapalhar a aformatacao. Este
	 * metodo pode receber um lista de TAGS que devem ser iguinoradas.
	 * 
	 * @param xmlContent
	 * @param charactersLength
	 * @return
	 */
	public static String resizeXml(String xmlContent, Integer charactersLength,
			String... noEndTags) {
		int contadorCaracteresValidos = 0;
		Stack<String> tags = new Stack<String>();
		StringBuilder builder = new StringBuilder();
		int beginTagIndex = -1;
		for (int i = 0; i < xmlContent.length(); i++) {
			if (xmlContent.charAt(i) == '<') {
				beginTagIndex = i;
			}
			if (xmlContent.charAt(i) == '<' && xmlContent.charAt(i + 1) != '/') {
				int endTagIndex = xmlContent.indexOf('>', i);
				String tag = xmlContent.substring(beginTagIndex,
						endTagIndex + 1);
				tags.push(tag);
				builder.append(tag);
				i = endTagIndex;
			} else if (xmlContent.charAt(i) == '<'
					&& xmlContent.charAt(i + 1) == '/') {
				int endTagIndex = xmlContent.indexOf('>', i);
				String tag = xmlContent.substring(beginTagIndex,
						endTagIndex + 1);
				tags.pop();
				builder.append(tag);
				i = endTagIndex;
			} else {
				contadorCaracteresValidos++;
				builder.append(xmlContent.charAt(i));
			}
			if (contadorCaracteresValidos >= charactersLength) {
				builder.append("...");
				for (String endTag : tags) {
					String[] tagsAtt = endTag.split(" ");
					String tag = tagsAtt[0].replaceAll("[<>]", " ").trim();
					boolean ehIgnoreTag = false;
					if (tagsAtt != null) {
						for (int j = 0; j < noEndTags.length; j++) {
							if (tag.equals(noEndTags[j])) {
								ehIgnoreTag = true;
								break;
							}
						}
					}
					if (!ehIgnoreTag) {
						builder.append("</" + tag + ">");
					}
				}
				break;
			}
		}
		if (tags != null && !tags.isEmpty()) {
			for (String endTag : tags) {
				String[] tagsAtt = endTag.split(" ");
				String tag = tagsAtt[0].replaceAll("[<>]", " ").trim();
				boolean ehIgnoreTag = false;
				if (tagsAtt != null) {
					for (int j = 0; j < noEndTags.length; j++) {
						if (tag.equals(noEndTags[j])) {
							ehIgnoreTag = true;
							break;
						}
					}
				}
				if (!ehIgnoreTag) {
					builder.append("</" + tag + ">");
				}
			}
		}
		return builder.toString();
	}

	public static String xmlfind(String value, String tag, String attribute) {
		if (value == null || tag == null) {
			return null;
		}

		if (tag != null) {
			String tags[] = tag.split(",");
			for (int i = 0; i < tags.length; i++) {
				String saida = XmlUtil.extractFirstTagFromXml(value, tag);
				if (saida != null) {
					value = saida;
				}
			}
		}

		if (attribute != null && value != null) {
			value = XmlUtil.extractAttributeValueFromXml(value, attribute);
		}
		/*
		 * Maior que 36 porque <img src="" width="230" alt="" /> e apresenta
		 * null e no IE6 fica errado
		 */
		if (value != null && value.length() > 36) {
			return value;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {

		// String xmlContent =
		//
		// "<P><IMG style=\"WIDTH: 448px; HEIGHT: 336px\" src=\"http://www.meioemensagem.com.br/mmonline/conteudo/fotos/72200873553David%20Droga%205.jpg\" align=middle></P><BR>"
		// +
		// "..br /..<P>Terminei a quarta-feira na Droga5, a mais nova agência dentre todas as que estou visitando. Fundada em abril de 2006 por David Droga, após ele ter passado alguns anos como o principal executivo global de criação do Publicis Groupe. Gostei do tom direto e despretensioso que ele posiciona sua agência. \"Não tenho nada contra o comercial de 30 segundos nem contra as agências tradicionais nem vou revolucionar nada. Afinal, eu sou fruto desse ambiente. Quero apenas fazer algo melhor. O que aconteceu é que eu tinha um cargo absolutamente burocrático e árduo. Passava três semanas por mês viajando ao redor do mundo. Eu me vi participando de um sistema tão grandioso, no qual eu não conseguia fazer a diferença que eu gostaria de fazer e tomei a decisão de montar meu próprio negócio para poder ter mais autonomia e fazer o que eu realmente acredito\", diz Droga, que faz questão de enfatizar que a Droga5 é independente e não tem participação acionária do Publicis Groupe, como todo mundo pensa. \"A Publicis é sócia apenas da <A style=\"TEXT-DECORATION: underline\" href=\"http://www.honeyshed.com\">Honeyshed</A>, empresa de brand entertnaiment que lançamos há três meses e que está ainda em fase beta\", enfatiza. Com pouco mais de um ano de atividade, a Droga5 conquistou na edição passada do Festival de Cannes o Titanium Lions pela campanha muito bem amarrada Tap Project criada para a Unicef, o que contribui enormemente para sua rápida visibilidade.<BR>"
		// +
		// "..br /..<OBJECT height=355 width=425><PARAM NAME=\"movie\" VALUE=\"http://www.youtube.com/v/Uzs-Lm0AvRU&amp;rel=1\"><PARAM NAME=\"wmode\" VALUE=\"transparent\">"
		// +
		// "..br /..<embed src=\"http://www.youtube.com/v/Uzs-Lm0AvRU&rel=1\" type=\"application/x-shockwave-flash\" wmode=\"transparent\" width=\"425\" height=\"355\"></embed></OBJECT><BR></P>"
		// ;
		//			
		// String saida = resizeXml(xmlContent, 1000, "br");
		// System.out.println(saida);

		// URL url = new URL("http","www.hotmedia.com.br",
		// "/mmonlinetv/getXMLPesqVideo/?strBusca=guinness");
		// URLConnection connection = url.openConnection();
		// InputStream input = connection.getInputStream();
		//	
		// XStream xml = new XStream();
		// xml.registerConverter(new
		// XStreamDateConverter("yyyy-MM-dd hh:mm:ss"));
		// xml.processAnnotations(MultimediaBuscaVideoEnvelope.class);
		// MultimediaBuscaVideoEnvelope obj = (MultimediaBuscaVideoEnvelope)
		// xml.fromXML(input);
		//	

	}
}
