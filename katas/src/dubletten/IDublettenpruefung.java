package dubletten;

import java.util.List;

public interface IDublettenpruefung {
	public List<IDublette> sammle_kandidaten(String pfad);
	public List<IDublette> sammle_kandidaten(String pfad, Vergleichsmodi modus);
	
	public enum Vergleichsmodi { Groe�e, Groe�e_und_Name}
	
	public interface IDublette {
		public List<String> getDateipfade();
	}
}
