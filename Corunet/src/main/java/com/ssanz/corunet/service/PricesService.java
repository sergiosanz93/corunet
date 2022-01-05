package com.ssanz.corunet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssanz.corunet.entity.Prices;
import com.ssanz.corunet.idao.IPricesDAO;
import com.ssanz.corunet.iservice.IPricesService;
import com.ssanz.corunet.vo.SalidaDatosVO;

@Service
public class PricesService implements IPricesService{

	@Autowired
	IPricesDAO pricesDAO;

	@Override
	public List<Prices> findDatosPricesBrand(Date fechaAplicacion, Integer brandID, Integer productID) {
		return pricesDAO.findDatosPricesBrand(fechaAplicacion, brandID, productID);
	}

	@Override
	public List<SalidaDatosVO> formatLstPricesToJson(List<Prices> lstPrices) {
		List<SalidaDatosVO> lstSalida = new ArrayList<SalidaDatosVO>();
		lstPrices.stream().forEach((price) -> {
			SalidaDatosVO s = new SalidaDatosVO(price.getProductID(), price.getBrandID(), price.getPriceList(), price.getStartDate(), 
					price.getEndDate(), price.getPrice(), price.getCurrency());
			lstSalida.add(s);			
		});
		return lstSalida;
	}
	
	
	
}
