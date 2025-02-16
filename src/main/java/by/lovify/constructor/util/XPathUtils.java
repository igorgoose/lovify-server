package by.lovify.constructor.util;

import lombok.experimental.UtilityClass;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

@UtilityClass
public class XPathUtils {

    public static final XPathFactory X_PATH_FACTORY = XPathFactory.newInstance();
    public static final XPath X_PATH = X_PATH_FACTORY.newXPath();

    public static XPathExpression initXPathExpression(String expression) {
        try {
            return X_PATH.compile(expression);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

}
