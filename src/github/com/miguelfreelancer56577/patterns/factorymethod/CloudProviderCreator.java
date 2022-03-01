package github.com.miguelfreelancer56577.patterns.factorymethod;

import github.com.miguelfreelancer56577.patterns.factory.service.CloudService;

public interface CloudProviderCreator {
	CloudService getInstance();
}
