/*
 * Copyright 2020 Uppsala University Library
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.uu.ub.diva.cora.fitnesse;

import se.uu.ub.cora.data.DataAttribute;

public class DataAttributeSpy implements DataAttribute {

	private String id;
	private String value;

	public DataAttributeSpy(String id, String value) {
		this.id = id;
		this.value = value;
	}

	@Override
	public String getNameInData() {
		return id;
	}

	@Override
	public String getValue() {
		return value;
	}

}
