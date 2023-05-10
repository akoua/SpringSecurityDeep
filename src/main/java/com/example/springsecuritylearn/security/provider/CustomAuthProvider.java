package com.example.springsecuritylearn.security.provider;

public class CustomAuthProvider {
//public class CustomAuthProvider implements AuthenticationProvider {
//    @Autowired
//    private CustomerRepository repository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        List<Customer> customers = repository.findCustomersByEmail(authentication.getName());
//        customers = !customers.isEmpty() ? customers :
//                repository.findCustomersByNumber(authentication.getName());
//        if (customers.size() > 1) {
//            throw new TooManyRowsAffectedException("trop de numéro asscocié", 1, customers.size());
//        } else if (customers.size() == 1) {
//            var cust = customers.get(0);
//            if (passwordEncoder.matches(authentication.getCredentials().toString(), cust.getPwd())) {
//                return new UsernamePasswordAuthenticationToken(authentication.getName(), cust.getPwd(), SecurityUtils.getGrantedAuthorities(cust.getAuthorities()));
//            } else {
//                throw new BadCredentialsException("username/pwd incorrect");
//            }
//        } else {
//            throw new BadCredentialsException("username/pwd incorrect");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
}

