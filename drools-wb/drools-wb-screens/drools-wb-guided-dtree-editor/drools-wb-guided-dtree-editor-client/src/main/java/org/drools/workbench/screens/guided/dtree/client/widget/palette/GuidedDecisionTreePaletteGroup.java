/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.workbench.screens.guided.dtree.client.widget.palette;

import com.emitrom.lienzo.client.core.shape.Layer;
import com.emitrom.lienzo.client.widget.LienzoPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.kie.uberfire.wires.core.api.factories.FactoryHelper;
import org.kie.uberfire.wires.core.api.factories.ShapeFactory;
import org.kie.uberfire.wires.core.client.canvas.FocusableLienzoPanel;
import org.kie.uberfire.wires.core.client.palette.PaletteShape;
import org.kie.uberfire.wires.core.client.util.ShapeFactoryUtil;

public class GuidedDecisionTreePaletteGroup extends VerticalPanel {

    public void addStencil( final ShapeFactory factory,
                            final GuidedDecisionTreeStencilPaletteBuilder stencilBuilder,
                            final FactoryHelper helper,
                            final boolean isReadOnly ) {
        final LienzoPanel panel = new FocusableLienzoPanel( GuidedDecisionTreeStencilPaletteBuilder.STENCIL_WIDTH,
                                                            GuidedDecisionTreeStencilPaletteBuilder.STENCIL_HEIGHT + ShapeFactoryUtil.SPACE_BETWEEN_BOUNDING );
        final Layer layer = new Layer();
        panel.getScene().add( layer );

        //Create a new PaletteShape from the given factory
        final PaletteShape shape = stencilBuilder.build( panel,
                                                         helper,
                                                         factory,
                                                         isReadOnly );

        layer.add( shape );
        layer.draw();
        add( panel );
    }

}