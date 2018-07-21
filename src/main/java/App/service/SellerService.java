/**
 * 
 */
/**
 * @author ysathe
 *
 */
package App.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.model.*;
import App.taskdao.*;

@Service
public class SellerService {

	@Autowired
	private SellerRepository wRepository;
	
	@Autowired
	private SellerService service;

	
	public List<Seller> findAll(){
		List<Seller> sellerList = new ArrayList<Seller>();
		for(Seller s : wRepository.findAll())
		{
			sellerList.add(s);
		}
		return sellerList;
	}
	
	   public void addSellerData(Seller sell)
	    {
			   wRepository.save(sell);
	    }
	    
	    public void deleteSellerData(long  id)
	    {
			   wRepository.delete(id);
	    }
	    	    
	    public Seller findOne(long  id) {
	    	return wRepository.findOne(id);
	    }
	    
}