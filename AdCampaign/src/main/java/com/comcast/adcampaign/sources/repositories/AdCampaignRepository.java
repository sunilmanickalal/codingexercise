package com.comcast.adcampaign.sources.repositories;

import org.springframework.data.repository.CrudRepository;

import com.comcast.adcampaign.sources.entities.Campaign;

/**
 * @author Sunil Manickalal
 * @version 1.0
 * <br>
 * This is the DB repository for ad campaign
 */

public interface AdCampaignRepository extends CrudRepository<Campaign, String> {

}
