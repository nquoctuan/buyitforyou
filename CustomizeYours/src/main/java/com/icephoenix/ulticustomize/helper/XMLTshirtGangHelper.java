package com.icephoenix.ulticustomize.helper;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.icephoenix.ulticustomize.model.OrderResponse;
import com.icephoenix.ulticustomize.model.TshirtGangOrder;
import com.icephoenix.ulticustomize.model.ProductResponse;
import com.icephoenix.utilcustomize.enu.TshirtGangColorEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangPriShippingEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangSizeEnum;
import com.icephoenix.utilcustomize.enu.TshirtGangStyleEnum;

public class XMLTshirtGangHelper {

	static final Logger logger = Logger
			.getLogger(XMLTshirtGangHelper.class);
	
	public static String createOrder(String key, TshirtGangOrder order) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element root = doc.createElement("OrderForm");

			doc.appendChild(root);
			root.appendChild(getAuth(doc, key));
			root.appendChild(getOrder(doc, order));

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult content = new StreamResult(new StringWriter());
			transformer.transform(source, content);

			return content.getWriter().toString();

		} catch (ParserConfigurationException
				| TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}

		return "";
	}

	public static String createProduct(String key, TshirtGangProduct product, String appID) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element root = doc.createElement("ProductForm");

			doc.appendChild(root);
			root.appendChild(getAuth(doc, key));
			root.appendChild(getProduct(doc, product.title, product.color, product.style, product.category,
					product.image, product.keywords));
			root.appendChild(getProductExtra(doc, appID));

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult content = new StreamResult(new StringWriter());
			transformer.transform(source, content);

			return content.getWriter().toString();

		} catch (ParserConfigurationException
				| TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}

		return "";
	}

	private static Node getProductExtra(Document doc, String appID) {
		Element node = doc.createElement("Extra");
		node.appendChild(createNodeWithTextNode(doc, "appID", appID));
		return node;
	}

	private static Node getProduct(Document doc, String title, String color,
			String style, String category, String image, String keywords) {
		Element node = doc.createElement("Product");
		node.appendChild(createNodeWithTextNode(doc, "title", title));
		node.appendChild(createNodeWithTextNode(doc, "color", color));
		node.appendChild(createNodeWithTextNode(doc, "style", style));
		node.appendChild(createNodeWithTextNode(doc, "category", category));
		node.appendChild(createNodeWithTextNode(doc, "image", image));
		node.appendChild(createNodeWithTextNode(doc, "keywords", keywords));

		return node;
	}

	private static Node getOrder(Document doc, TshirtGangOrder order) {
		Element node = doc.createElement("Order");
		node.appendChild(createNodeWithTextNode(doc, "fullname", order.fullname));
		node.appendChild(createNodeWithTextNode(doc, "address1", order.address1));
		node.appendChild(createNodeWithTextNode(doc, "address2", order.address2));
		node.appendChild(createNodeWithTextNode(doc, "city", order.city));
		node.appendChild(createNodeWithTextNode(doc, "postal", order.postal));
		node.appendChild(createNodeWithTextNode(doc, "state", order.state));
		node.appendChild(createNodeWithTextNode(doc, "country", order.country));
		node.appendChild(createNodeWithTextNode(doc, "sku", order.sku));
		node.appendChild(createNodeWithTextNode(doc, "size", order.size.name()));
		node.appendChild(createNodeWithTextNode(doc, "size", order.style.name()));
		node.appendChild(createNodeWithTextNode(doc, "color",
				order.color.name()));
		node.appendChild(createNodeWithTextNode(doc, "quantity", order.quantity));
		node.appendChild(createNodeWithTextNode(doc, "priorityShipping",
				order.priorityShipping.values().toString()));
		return node;
	}

	private static Node getAuth(Document doc, String key) {
		Element node = doc.createElement("Auth");
		node.appendChild(createNodeWithTextNode(doc, "key", key));
		return node;
	}

	private static Node createNodeWithTextNode(Document doc, String name,
			String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

	public static void main(String[] args) {
		String content = XMLTshirtGangHelper.createOrder("key",
				new TshirtGangOrder("Tuan", "address1", "address2", "HCM", "",
						"", "Vietnam", "123", TshirtGangSizeEnum.MEDIUM,
						TshirtGangStyleEnum.STANDARD,
						TshirtGangColorEnum.BLACK_RINGER, "1",
						TshirtGangPriShippingEnum.NO_EXPRESS));
		System.out.println("XML Content of Order is: " + content);

		content = XMLTshirtGangHelper.createProduct("key", new TshirtGangProduct("Title of Product", "Red", "Style 1", "Football", "234", "Halo"),
				"000-0001");
		System.out.println("XML Content of Product is: " + content);
	}

	public static OrderResponse parseResponse(String response) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		OrderResponse result = new OrderResponse();
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(
					response)));
			NodeList nodes = doc.getElementsByTagName("response"); // response
																	
			for (int index = 0; index <= nodes.getLength(); index++) {
				Node aNode = nodes.item(index); // success or failure
				if (aNode instanceof Element) {
					Element eleResponse = (Element) aNode;
					if (eleResponse.getTagName().equals("success")) {
						// success
						NodeList childNodes = aNode.getChildNodes();
						for (int j = 0; j < childNodes.getLength(); j++) {
							Node item = childNodes.item(index);
							String value = item.getTextContent();
							switch (((Element)item).getTagName()) {
							case "orderID":
								result.orderId = value;
								break;
							case "price":
								result.price = value;
								break;
							case "priceShipping":
								result.priceShipping = value;
								break;
							case "tax":
								result.tax = value;
								break;
							default:
								break;

							}
						}
					} else {
						// failure
						NodeList childNodes = aNode.getChildNodes();
						for (int j = 0; j < childNodes.getLength(); j++) {
							Node item = childNodes.item(index);
							String value = item.getTextContent();
							switch (((Element)item).getTagName()) {
							case "errorCode":
								result.errorCode = Integer.valueOf(value);
								break;
							case "message":
								result.message = value;
								break;
							default:
								break;

							}
						}
					}
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	public static ProductResponse parseProductResponse(String response) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		ProductResponse result = new ProductResponse();
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(
					response)));
			NodeList nodes = doc.getElementsByTagName("response"); // response
																	
			for (int index = 0; index <= nodes.getLength(); index++) {
				Node aNode = nodes.item(index); // success or failure
				if (aNode instanceof Element) {
					Element eleResponse = (Element) aNode;
					if (eleResponse.getTagName().equals("success")) {
						// success
						NodeList childNodes = aNode.getChildNodes();
						for (int j = 0; j < childNodes.getLength(); j++) {
							Node item = childNodes.item(index);
							String value = item.getTextContent();
							switch (((Element)item).getTagName()) {
							case "productID":
								result.productId = value;
								break;
							case "returnImage":
								result.returnImage = value;
								break;
							default:
								break;
							}
						}
					} else {
						// failure
						NodeList childNodes = aNode.getChildNodes();
						for (int j = 0; j < childNodes.getLength(); j++) {
							Node item = childNodes.item(index);
							String value = item.getTextContent();
							switch (((Element)item).getTagName()) {
							case "errorCode":
								result.errorCode = Integer.valueOf(value);
								break;
							case "message":
								result.message = value;
								break;
							default:
								break;

							}
						}
					}
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	public static String createMultiOrder(String key,
			TshirtGangOrder[] orders) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element root = doc.createElement("OrderForm");

			doc.appendChild(root);
			root.appendChild(getAuth(doc, key));
			for (TshirtGangOrder order : orders) {
				root.appendChild(getOrder(doc, order));
			}

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult content = new StreamResult(new StringWriter());
			transformer.transform(source, content);

			return content.getWriter().toString();

		} catch (ParserConfigurationException
				| TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}

		return "";
	}
}
