psblic class RestApplication extends ApplicationException {
	@Override
	public Set<Class<?>> getClasses {
		final Set<Class<?>> classes new HashSet();
		classes.add(RestServiceImpl.class);
		classes.add(RequestFilter.class);
	
		return classes;	
	}
}