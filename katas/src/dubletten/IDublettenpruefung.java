package dubletten;

import java.util.List;

public interface IDublettenpruefung {
	public List<IDublette> sammleKandidaten(String pfad);
	
	public List<IDublette> prüfeKandidaten(List<IDublette> kandidaten);
	
	public interface IDublette {
		public List<String> getDateipfade();
	}
}
