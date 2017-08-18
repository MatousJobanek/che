/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.workspace.infrastructure.docker.provisioner.server;

import org.eclipse.che.api.core.model.workspace.runtime.RuntimeIdentity;
import org.eclipse.che.commons.annotation.Nullable;
import org.eclipse.che.commons.lang.Pair;

/**
 * Provides an environment variable which is needed for servers used by Che for providing IDE features.
 *
 * @author Alexander Garagatyi
 */
public interface ServerEnvironmentVariableProvider {
    /**
     * Returns environment variable which should be injected into container environment or {@code null} otherwise.
     *
     * @param runtimeIdentity which may be needed to evaluate environment variable value
     */
    @Nullable
    Pair<String, String> get(RuntimeIdentity runtimeIdentity);
}