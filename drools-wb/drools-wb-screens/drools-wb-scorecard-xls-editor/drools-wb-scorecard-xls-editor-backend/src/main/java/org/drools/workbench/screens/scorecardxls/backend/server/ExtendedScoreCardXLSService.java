/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
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

package org.drools.workbench.screens.scorecardxls.backend.server;

import java.io.InputStream;

import org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService;
import org.uberfire.backend.vfs.Path;

public interface ExtendedScoreCardXLSService extends ScoreCardXLSService {

    InputStream load( final Path path,
                      final String sessionId );

    Path create( final Path resource,
                 final InputStream content,
                 final String sessionId,
                 final String comment );

    Path save( final Path resource,
               final InputStream content,
               final String sessionId,
               final String comment );

}
