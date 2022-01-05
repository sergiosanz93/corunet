package com.ssanz.corunet.iservice;

import java.util.Date;
import java.util.List;

import com.ssanz.corunet.entity.Prices;
/**
 * Services de {@link Prices}
 * 
 * @author Sergio
 *
 */
import com.ssanz.corunet.vo.SalidaDatosVO;
public interface IPricesService {

	/**
	 * Devuelve una {@link List} de {@link Prices} teniendo en cuenta los valores pasados por parametro
	 * @param fechaAplicacion
	 * @param brandID
	 * @param productID
	 * @return
	 */
	List<Prices> findDatosPricesBrand(Date fechaAplicacion , Integer brandID,  Integer productID);
	
	/**
	 * Devuelve una {@link List} de {@link SalidaDatosVO} creada a base de un {@link List} de {@link Prices} pasada por parametro
	 * @param lstPrices
	 * @return
	 */
	List<SalidaDatosVO> formatLstPricesToJson(List<Prices> lstPrices);
}
