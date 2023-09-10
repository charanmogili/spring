package in.charan.service;

import java.util.List;

import in.charan.model.Tourist;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer id);
	public String updateTouristByDetails(Tourist tourist);
	public String updateTouristById(Integer id,Float hikePercent);
	public String deleteTouristById(Integer id);
}
