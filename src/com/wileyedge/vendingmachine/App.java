package com.wileyedge.vendingmachine;

import com.wileyedge.controller.VendingMachineController;
import com.wileyedge.dao.VendingMachineAuditDao;
import com.wileyedge.dao.VendingMachineAuditDaoFileImpl;
import com.wileyedge.dao.VendingMachineDao;
import com.wileyedge.dao.VendingMachineDaoFileImpl;
import com.wileyedge.service.VendingMachineServiceLayer;
import com.wileyedge.service.VendingMachineServiceLayerImpl;
import com.wileyedge.ui.UserIO;
import com.wileyedge.ui.UserIOConsoleImpl;
import com.wileyedge.ui.VendingMachineView;

public class App {
	public static void main(String[] args) {
		UserIO myIo = new UserIOConsoleImpl();
		VendingMachineView myView = new VendingMachineView(myIo);
		VendingMachineDao myDao = new VendingMachineDaoFileImpl();
		VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
		VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
		VendingMachineController controller = new VendingMachineController(service, myView);
		controller.run();

	}

}
