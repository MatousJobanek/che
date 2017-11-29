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
package org.eclipse.che.plugin.optimized.testing.ide;

import org.eclipse.che.plugin.testing.ide.TestLocalizationConstant;

/**
 * Localization constants for optimized test extension
 *
 * @author Mirage Abeysekara
 */
public interface OptimizedTestLocalizationConstant extends TestLocalizationConstant {

  /* Actions */

  @Key("actionGroup.menu.name")
  String actionGroupMenuName();

  @Key("contextActionGroup.menu.name")
  String contextActionGroupMenuName();

  /* Test result panel */

  @Key("title.optimizedTestResultPanel")
  String titleOptimizedTestResultPanel();

  /* Preferences */

  @Key("smartTesting.title")
  String smartTestingTitle();
}