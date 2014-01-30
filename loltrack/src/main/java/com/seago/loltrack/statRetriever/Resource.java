package com.seago.loltrack.statRetriever;

import java.lang.reflect.Field;

public abstract class Resource {
	boolean	success;
	String	error;

	public boolean getSuccess() {
		return this.success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return this.error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		//determine fields declared in this class only (no fields of superclass)
		Field[] fields1 = this.getClass().getDeclaredFields();

		//print field names paired with their values for this class only
		for (Field field : fields1) {
			if (!(field == fields1[fields1.length-1])) {
				result.append("  ");
				try {
					result.append(field.getName());
					result.append(": ");
					//requires access to private field:
					result.append(field.get(this));
				} catch (IllegalAccessException ex) {
					System.out.println(ex);
				}
				result.append(newLine);
			}
		}

		return result.toString();
	}
}
