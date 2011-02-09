/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.util.xml.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class StartPrefixMapping extends SAXEvent {
	private String prefix;
	private String uri;

	private StartPrefixMapping() {
		super(EventType.START_PREFIX_MAPPING);
	}
	
	public StartPrefixMapping(String prefix, String uri) {
		this();
		this.prefix = prefix;
		this.uri = uri;
	}

	@Override
	public StartPrefixMapping shallowCopy() {
		StartPrefixMapping startPrefixMapping = new StartPrefixMapping();
		startPrefixMapping.prefix = prefix;
		startPrefixMapping.uri = uri;
		
		return startPrefixMapping;
	}

	@Override
	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.startPrefixMapping(prefix, uri);
	}
	
	@Override
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

	public String getPrefix() {
		return prefix;
	}

	public String getUri() {
		return uri;
	}

}