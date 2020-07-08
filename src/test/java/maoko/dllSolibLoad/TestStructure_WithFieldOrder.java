package maoko.dllSolibLoad;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder("a,b")
public class TestStructure_WithFieldOrder extends Structure {
	public int a;
	public int b;
}
