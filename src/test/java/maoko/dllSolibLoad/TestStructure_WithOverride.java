package maoko.dllSolibLoad;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class TestStructure_WithOverride extends Structure {

	public int a;
	public int b;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("a", "b");
	}
}
