package dubletten;

import java.util.List;

public interface IDublettenpruefung {
	public List<IDublette> sammleKandidaten(String pfad);
	
	public interface IDublette {
		public List<String> getDateipfade();
	}
}
