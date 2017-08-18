/*******************************************************************************
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.api.debug.shared.model.impl;

import com.google.common.base.Objects;

import org.eclipse.che.api.debug.shared.model.StackFrameDump;
import org.eclipse.che.api.debug.shared.model.ThreadDump;
import org.eclipse.che.api.debug.shared.model.ThreadStatus;

import java.util.List;

/**
 * @author Anatolii Bazko
 */
public class ThreadDumpImpl implements ThreadDump {
    private final String                         name;
    private final String                         groupName;
    private final ThreadStatus                   status;
    private final boolean                        isSuspended;
    private final List<? extends StackFrameDump> frames;
    private final long                           id;

    public ThreadDumpImpl(long id,
                          String name,
                          String groupName,
                          ThreadStatus status,
                          boolean isSuspended,
                          List<? extends StackFrameDump> frames) {
        this.name = name;
        this.groupName = groupName;
        this.status = status;
        this.isSuspended = isSuspended;
        this.frames = frames;
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }

    @Override
    public ThreadStatus getStatus() {
        return status;
    }

    @Override
    public boolean isSuspended() {
        return isSuspended;
    }

    @Override
    public List<? extends StackFrameDump> getFrames() {
        return frames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThreadDumpImpl)) return false;
        ThreadDumpImpl that = (ThreadDumpImpl)o;
        return isSuspended == that.isSuspended &&
               id == that.id &&
               Objects.equal(name, that.name) &&
               Objects.equal(groupName, that.groupName) &&
               status == that.status &&
               Objects.equal(frames, that.frames);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, groupName, status, isSuspended, frames, id);
    }

    @Override
    public String toString() {
        return "ThreadDumpImpl{" +
               "name='" + name + '\'' +
               ", groupName='" + groupName + '\'' +
               ", status=" + status +
               ", isSuspended=" + isSuspended +
               ", frames=" + frames +
               ", id=" + id +
               '}';
    }
}