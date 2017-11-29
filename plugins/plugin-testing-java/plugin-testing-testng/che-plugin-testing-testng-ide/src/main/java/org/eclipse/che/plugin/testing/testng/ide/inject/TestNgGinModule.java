/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.testing.testng.ide.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.optimized.testing.ide.OptimizedTestAction;
import org.eclipse.che.plugin.testing.ide.action.TestAction;
import org.eclipse.che.plugin.testing.ide.detector.TestFileExtension;
import org.eclipse.che.plugin.testing.testng.ide.OptimizedTestNgTestAction;
import org.eclipse.che.plugin.testing.testng.ide.TestNgTestAction;
import org.eclipse.che.plugin.testing.testng.ide.TestNgTestFileExtension;

/** Gin module for TestNg extension. */
@ExtensionGinModule
public class TestNgGinModule extends AbstractGinModule {
  @Override
  protected void configure() {
    GinMultibinder.newSetBinder(binder(), TestAction.class).addBinding().to(TestNgTestAction.class);
    GinMultibinder.newSetBinder(binder(), TestFileExtension.class)
        .addBinding()
        .to(TestNgTestFileExtension.class);
    GinMultibinder.newSetBinder(binder(), OptimizedTestAction.class)
        .addBinding()
        .to(OptimizedTestNgTestAction.class);
  }
}
