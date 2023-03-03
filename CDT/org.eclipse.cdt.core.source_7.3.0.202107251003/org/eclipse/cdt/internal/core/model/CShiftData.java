/*******************************************************************************
 * Copyright (c) 2006, 2011 Intel Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Intel Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.cdt.internal.core.model;

import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.ICElementDelta;
import org.eclipse.core.resources.IResourceDelta;

/**
 * In this case, no delta for specific element passed
 * Instead we'll notify Outline about offsets change.
 *
 * @author Oleg Krasilnikov
 */
public class CShiftData implements ICElementDelta {

	private final ICElement element;
	private final int offset;
	private final int size;
	private final int lines;

	public CShiftData(ICElement element, int offset, int size, int lines) {
		this.element = element;
		this.offset = offset;
		this.size = size;
		this.lines = lines;
	}

	public int getOffset() {
		return offset;
	}

	public int getSize() {
		return size;
	}

	public int getLines() {
		return lines;
	}

	@Override
	public ICElementDelta[] getAddedChildren() {
		return new ICElementDelta[0];
	}

	@Override
	public ICElementDelta[] getAffectedChildren() {
		return new ICElementDelta[0];
	}

	@Override
	public ICElementDelta[] getChangedChildren() {
		return new ICElementDelta[0];
	}

	@Override
	public ICElement getElement() {
		return element;
	}

	@Override
	public int getFlags() {
		return 0;
	}

	@Override
	public int getKind() {
		return 0;
	}

	@Override
	public ICElement getMovedFromElement() {
		return null;
	}

	@Override
	public ICElement getMovedToElement() {
		return null;
	}

	@Override
	public ICElementDelta[] getRemovedChildren() {
		return new ICElementDelta[0];
	}

	@Override
	public IResourceDelta[] getResourceDeltas() {
		return null;
	}

	@Override
	public String toString() {
		return ("CShiftData: offset=" + offset + ", size=" + size + ", lines=" + lines); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
	}
}
