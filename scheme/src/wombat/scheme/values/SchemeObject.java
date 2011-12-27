package wombat.scheme.values;

import java.io.Serializable;

/**
 * Base class for all Scheme objects.
 * 
 * @param <T> The internal Java object being stored (or null).
 */
public abstract class SchemeObject<T> implements Serializable {
	private static final long serialVersionUID = 7967428058437269262L;

	protected T Value;
	int Line;
	int Column;
	
	/**
	 * Create a new Scheme object.
	 * 
	 * @param value The Java value to store in the object.
	 */
	public SchemeObject(T value) {
		Value = value;
	}
	
	/**
	 * Set the location of this scheme object.
	 * @param line The line this object was created at.
	 * @param column The column this object was created at.
	 * @return This object.
	 */
	public SchemeObject<T> at(int line, int column) {
		Line = line;
		Column = column;
		return this;
	}
	
	/**
	 * Accessor for the value.
	 * @return The value.
	 */
	public T getValue() {
		return Value;
	}
	
	/**
	 * Return a human-readable version of the object (does not have to be machine readable).
	 * @return That string.
	 */
	public String display() {
		return Value.toString();
	}
	
	/**
	 * Return a machine-readable version of the object.
	 * @return That string.
	 */
	public String write() {
		return Value.toString();
	}
	
	/**
	 * Return a String version of the object for debugging purposes.
	 * @return That string.
	 */
	public String toString() {
		return (Value.toString() + ":" + getClass().getName()).replaceAll("wombat.scheme.values(.numeric)?.Scheme", "");
	}
	
	/**
	 * Check if two Scheme objects are equal.
	 * 
	 * @param that The other Scheme object.
	 * @return True or false.
	 */
	public boolean equals(Object that) {
		return (!(that == null)
				&& (that instanceof SchemeObject<?>) 
				&& ((Value == null && ((SchemeObject<?>) that).Value == null)
						|| Value.equals(((SchemeObject<?>) that).Value)));
	}
}