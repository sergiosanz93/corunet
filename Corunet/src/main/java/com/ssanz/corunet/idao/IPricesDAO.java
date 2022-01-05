package com.ssanz.corunet.idao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ssanz.corunet.entity.Prices;
import com.ssanz.corunet.vo.SalidaDatosVO;

public interface IPricesDAO extends JpaRepository<Prices, Integer> {
	/**
	 * Devuelve una {@link List} de {@link SalidaDatosVO} con los datos de la tabla {@link SalidaDatosVO} filtrando 
	 * por los paramentros de entrada
	 * 
	 * @param fechaAplicacion
	 * @param brandID
	 * @param productId
	 * @return
	 */
	@Query("FROM Prices p "
			+ "WHERE p.productID = :#{#product} "
			+ "AND p.brandID.id = :#{#brand} "
			+ "AND :#{#fecha} BETWEEN p.startDate AND p.endDate")
	List<Prices> findDatosPricesBrand(
			@Param("fecha") Date fechaAplicacion, 
			@Param("brand") Integer brandID, 
			@Param("product") Integer productId);
}
