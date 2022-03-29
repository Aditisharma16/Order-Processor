package com.orderprocessor.model.dto.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.orderprocessor.model.dao.order.Order;

/**
 * @author VE00YM341
 * @createdOn : 22/03/2022
 * @updateOn : 
 * @updatedBy : 
 *
 */
public class DateOrderMapper {
	
	private DateOrderMapper() {

	}
	
	/**
	* @author VE00YM341
	* converting
	* @param User
	* @return void
	* @throws 
	*/
public static List<DateOrderDto> convertToDateOrder(List<Order> order) {
	 List<DateOrderDto> orderDto = new ArrayList<>();
	 	for(Order o : order) {
	 		DateOrderDto dto = new DateOrderDto();
	 		dto.setId(o.getId());
	 		dto.setOrderNumber(o.getOrderNumber());
	 		dto.setShippingAddress(o.getShippingAddress());
	 		dto.setDeliveryDate(convertDate(o.getDeliveryDate()));
	 		dto.setCustomerName(o.getCustomerName());
	 		dto.setCustomerPhoneno(o.getCustomerPhoneno());
	 		dto.setTotalPrice(o.getTotalPrice());
	 		dto.setCreatedBy(o.getCreatedBy());
	 		dto.setCreatedOn(convertDate(o.getCreatedOn()));
	 		dto.setUpdatedBy(o.getUpdatedBy());
	 		dto.setUpdatedOn(null);
	 		dto.setStatusId(o.getStatusId());
	 		dto.setDeleted(false);
	 		orderDto.add(dto);
	 	}
	 	return orderDto;
}

// converting localdatetime to date only
public static String convertDate(LocalDateTime date) {
	return DateTimeFormatter.ISO_DATE.format(date);
}

}
