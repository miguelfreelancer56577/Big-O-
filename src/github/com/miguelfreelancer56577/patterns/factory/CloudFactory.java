package github.com.miguelfreelancer56577.patterns.factory;

import java.util.Objects;

import github.com.miguelfreelancer56577.patterns.factory.dto.CloudProvider;
import github.com.miguelfreelancer56577.patterns.factory.service.CloudService;
import github.com.miguelfreelancer56577.patterns.factory.service.impl.AwsProvider;
import github.com.miguelfreelancer56577.patterns.factory.service.impl.AzureProvider;

public class CloudFactory {
	
	private CloudFactory() {}
	
	public static CloudService getInstance(CloudProvider cloudProvider) {
		Objects.requireNonNull(cloudProvider);
		if(CloudProvider.AWS.equals(cloudProvider)) {
			return new AwsProvider();
		}else {
			return new AzureProvider();
		}
	}

}
