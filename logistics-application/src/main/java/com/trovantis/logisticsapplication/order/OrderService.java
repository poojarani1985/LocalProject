package com.trovantis.logisticsapplication.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.trovantis.logisticsapplication.util.OrderStatus;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	// for saving a new order/quotation
	public Order saveQuotation(Order order) {
		setOrderStatus(order, OrderStatus.NEW);
		return orderRepo.save(order);
	}

	void setOrderStatus(Order order, OrderStatus status) {
		order.setStatus(status);
	}

	public Order getOrderDetails(int orderId) {
		return orderRepo.findById(orderId);
	}

	// for updating the order status
	public void updateOrderStatus(int orderId, OrderStatus orderStatus) {
		orderRepo.updateStatus(orderId, orderStatus);
	}

	// for getting all orders
	public Page<Order> getAllOrders(int pageNo, int pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Order> page = orderRepo.findAll(paging);

		List<Order> orderList = page.getContent();
		if (orderList.size() > 0) {
			for (Order order : orderList) {
				OrderStatus orderStatus = order.getStatus();
				if (orderStatus == OrderStatus.NEW || orderStatus == OrderStatus.QUOTATION
						|| orderStatus == OrderStatus.PRICE_QUOTES)
					order.setStatus(OrderStatus.QUOTATION_PREPARING);
			}
			page = new PageImpl<>(orderList);
		}
		return page;
	}
	
	// for getting all orders
		public Page<OrderFleetOwnerResult> getAllFleetOwnerOrders(int pageNo, int pageSize, String sortBy, int fleetOwnerId) {
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<OrderFleetOwnerResult> page = orderRepo.findOrdersByFleetOwnerId(fleetOwnerId, paging);

			List<OrderFleetOwnerResult> orderList = page.getContent();
			if (orderList.size() > 0) {
				for (OrderFleetOwnerResult order : orderList) {
					OrderStatus orderStatus = order.getStatus();
					if (orderStatus == OrderStatus.NEW || orderStatus == OrderStatus.QUOTATION
							|| orderStatus == OrderStatus.PRICE_QUOTES)
						order.setStatus(OrderStatus.QUOTATION_PREPARING);
				}
				page = new PageImpl<>(orderList);
			}
			return page;
		}


	// for getting all orders for customer
	public List<OrderCustomerResult> getAllCustomerOrders(int customerId) {
		return orderRepo.findOrdersByCustomerId(customerId);
	}

}
