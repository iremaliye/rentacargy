package com.turkcell.rentacar.business.dtos.requests.creates;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalforCorporateRequest {
	
//	@NotNull
//	private int carId;
//	@NotNull
//	private int customerId;
	@NotNull
	private int paymentId;
}
