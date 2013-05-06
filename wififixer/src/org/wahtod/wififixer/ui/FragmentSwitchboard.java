/*	    Wifi Fixer for Android
    Copyright (C) 2010-2013  David Van de Ven

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses
 */

package org.wahtod.wififixer.ui;

import java.lang.reflect.Method;

import android.os.Bundle;

public class FragmentSwitchboard extends BaseDialogFragment {
	public static final String FRAGMENT_KEY = "FRAGMENT";
	public static final String METHOD = "newInstance";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static FragmentSwitchboard newInstance(Bundle bundle) {
		try {
			String s = bundle.getString(FRAGMENT_KEY);
			Class c = Class.forName(s);
			Class p[] = new Class[1];
			p[0] = Bundle.class;
			Method m = c.getMethod(METHOD, p);
			return (FragmentSwitchboard) m.invoke(c, bundle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Default behavior if no valid objects found
		 */
		return new AboutFragment();
	}
}