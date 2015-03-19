package com.ezrebclan.visualscript.component;

import org.json.JSONObject;

public abstract class ScriptComponent {

	public abstract boolean create(Context context);
	public abstract JSONObject run(Context context);
	public abstract boolean draw(Context context);
}
