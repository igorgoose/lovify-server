package by.lovify.model.constructor;

import org.w3c.dom.Element;

import java.awt.geom.Point2D;

public record Anchor(String id, Point2D coordinates, float size, Element element) {

}
