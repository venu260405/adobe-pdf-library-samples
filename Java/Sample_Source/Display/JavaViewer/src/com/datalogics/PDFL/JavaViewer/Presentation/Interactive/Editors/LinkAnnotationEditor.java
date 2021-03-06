/*
 * Copyright (C) 2011-2017, Datalogics, Inc. All rights reserved.
 * 
 * For complete copyright information, refer to:
 * http://dev.datalogics.com/adobe-pdf-library/license-for-downloaded-pdf-samples/
 *
 */

package com.datalogics.PDFL.JavaViewer.Presentation.Interactive.Editors;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.datalogics.PDFL.JavaViewer.Document.Annotations.AnnotationProperties;

/**
 * LinkAnnotationEditor - allows to draw PDFL.LinkAnnotation on the page.
 */
public class LinkAnnotationEditor extends BaseAnnotationEditor {
    @Override
    protected void doDrawShape(Graphics2D gr) {
        final AnnotationProperties annotationProperties = getProperties();
        final int penWidth = (int) Math.round(annotationProperties.getLineWidth() * getPageModel().getScale());

        Rectangle boundingRect = getPageModel().transform(annotationProperties.getBoundingRect());
        boundingRect.grow(-penWidth / 2, -penWidth / 2); // consider pen width for circle bounds

        gr.setColor(annotationProperties.getForeColor());
        gr.drawRect(boundingRect.x, boundingRect.y, boundingRect.width, boundingRect.height);
    }
}
