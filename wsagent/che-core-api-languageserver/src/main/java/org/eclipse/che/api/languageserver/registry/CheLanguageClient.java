/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.api.languageserver.registry;

import java.util.concurrent.CompletableFuture;
import org.eclipse.che.api.core.notification.EventService;
import org.eclipse.che.api.languageserver.shared.model.ExtendedPublishDiagnosticsParams;
import org.eclipse.lsp4j.MessageActionItem;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.ShowMessageRequestParams;
import org.eclipse.lsp4j.services.LanguageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A LSP language client implementation for Che
 *
 * @author Thomas Mäder
 */
public class CheLanguageClient implements LanguageClient {
  private static final Logger LOG = LoggerFactory.getLogger(CheLanguageClient.class);

  private EventService eventService;
  private String serverId;

  public CheLanguageClient(EventService eventService, String serverId) {
    this.eventService = eventService;
    this.serverId = serverId;
  }

  @Override
  public void telemetryEvent(Object object) {
    // not supported yet.
  }

  @Override
  public CompletableFuture<MessageActionItem> showMessageRequest(
      ShowMessageRequestParams requestParams) {
    return CompletableFuture.completedFuture(null);
  }

  @Override
  public void showMessage(MessageParams messageParams) {
    eventService.publish(messageParams);
  }

  @Override
  public void publishDiagnostics(PublishDiagnosticsParams diagnostics) {
    eventService.publish(new ExtendedPublishDiagnosticsParams(serverId, diagnostics));
  }

  @Override
  public void logMessage(MessageParams message) {
    switch (message.getType()) {
      case Error:
        LOG.error(message.getMessage());
        break;
      case Warning:
        LOG.warn(message.getMessage());
        break;
      case Info:
        LOG.info(message.getMessage());
        break;
      case Log:
        LOG.debug(message.getMessage());
        break;
    }
  }
}
