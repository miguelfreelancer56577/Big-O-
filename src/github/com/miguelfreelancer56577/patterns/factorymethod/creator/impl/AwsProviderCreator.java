package github.com.miguelfreelancer56577.patterns.factorymethod.creator.impl;

import github.com.miguelfreelancer56577.patterns.factory.service.CloudService;
import github.com.miguelfreelancer56577.patterns.factory.service.impl.AwsProvider;
import github.com.miguelfreelancer56577.patterns.factorymethod.CloudProviderCreator;

public class AwsProviderCreator implements CloudProviderCreator{

	@Override
	public CloudService getInstance() {
		return new AwsProvider();
	}

}
