/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2015, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.styling;

import java.util.Arrays;
import java.util.List;

import org.opengis.filter.expression.Expression;
import org.opengis.style.ContrastMethod;

/**
 * @author iant
 *
 */
public class Normalize extends AbstractContrastEnhancementMethod{

    final static List<String> ALGORITHM_NAMES = Arrays.asList("StretchToMinimumMaximum",
            "ClipToMinimumMaximum", "ClipToZero");

    public Normalize() {
        NAME = "Normalize";
        method = ContrastMethod.NORMALIZE;
    }

    @Override
    public void setAlgorithm(Expression name) {
        if (name != null) {
            String algorithm = name.evaluate(null, String.class);
            if (algorithm != null && !ALGORITHM_NAMES.contains(algorithm)) {
                throw new IllegalArgumentException("Unsupported Algorithm has been specified: " + algorithm);
            }
        }
        super.setAlgorithm(name);
    }
}
