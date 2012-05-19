/*
 * Copyright 2011 JBoss Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.drools.guvnor.client.decisiontable.widget.events;

import java.util.List;

import org.drools.guvnor.client.widgets.drools.decoratedgrid.CellValue;
import org.drools.guvnor.client.widgets.drools.decoratedgrid.DynamicColumn;
import org.drools.guvnor.client.widgets.drools.decoratedgrid.events.InsertInternalColumnEvent;
import org.drools.ide.common.client.modeldriven.dt52.BaseColumn;

/**
 * An event to insert a column in the table
 */
public class InsertInternalDecisionTableColumnEvent extends InsertInternalColumnEvent<BaseColumn> {

    public InsertInternalDecisionTableColumnEvent(List<DynamicColumn<BaseColumn>> columns,
                                                  List<List<CellValue< ? extends Comparable< ? >>>> columnsData,
                                                  int index,
                                                  boolean redraw) {
        super( columns,
               columnsData,
               index,
               redraw );
    }

    public static Type<InsertInternalColumnEvent.Handler<BaseColumn>> TYPE = new Type<InsertInternalColumnEvent.Handler<BaseColumn>>();

    @Override
    public Type<InsertInternalColumnEvent.Handler<BaseColumn>> getAssociatedType() {
        return TYPE;
    }

}
