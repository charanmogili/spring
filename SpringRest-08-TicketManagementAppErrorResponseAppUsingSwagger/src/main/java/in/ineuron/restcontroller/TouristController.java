package in.ineuron.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/tourist")
@Validated
public class TouristController {

	private ITouristMgmtService service;

	public TouristController(ITouristMgmtService service) {
		this.service=service;
	}

	@PostMapping("/register")
	@ApiOperation("For Tourist Registration")
	public ResponseEntity<String> enrollTourist(@RequestBody @Valid Tourist tourist) {

		String resultMsg = service.registerTourist(tourist);
		return new ResponseEntity<>(resultMsg, HttpStatus.OK);
	}

	@GetMapping("/findAll")
	@ApiOperation("To Display Tourist Details")
	public ResponseEntity<List<Tourist>> displayTouristDetails() {

		List<Tourist> list = service.fetchAllTourist();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Tourist> displayTouristById(@PathVariable("id") Integer id) {

		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<>(tourist, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifytourist(@RequestBody Tourist tourist) {

		String msg = service.updateTouristByDetails(tourist);
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifytouristBudgetById(@PathVariable("id") Integer id,
			@PathVariable("hike") Float hikeAmt) {

		String msg = service.updateTouristById(id, hikeAmt);
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTouristById(@PathVariable("id") Integer id) {
		String msg = service.deleteTouristById(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
