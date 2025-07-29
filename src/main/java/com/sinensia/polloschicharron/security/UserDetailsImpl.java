package com.sinensia.polloschicharron.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinensia.polloschicharron.security.integration.model.UsuarioPL;

public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String firstName;
	private String lastName;
	private String email;
	private boolean enabled;
	private Collection<? extends GrantedAuthority> authorities;
	
	private UserDetailsImpl(UserDetailsBuilder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.enabled = builder.enabled;
        this.authorities = builder.authorities;
    }

    public static UserDetailsImpl build(UsuarioPL usuarioPL) {
        List<GrantedAuthority> roles = usuarioPL.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl.UserDetailsBuilder()
                .id(usuarioPL.getId())
                .username(usuarioPL.getUsername())
                .password(usuarioPL.getPassword())
                .firstName(usuarioPL.getFirstName())
                .lastName(usuarioPL.getLastName())
                .email(usuarioPL.getEmail())
                .enabled(usuarioPL.getEnabled())
                .authorities(roles)
                .build();
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public static class UserDetailsBuilder {
        private Long id;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private boolean enabled;
        private Collection<? extends GrantedAuthority> authorities;

        public UserDetailsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserDetailsBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDetailsBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDetailsBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDetailsBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDetailsBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDetailsBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public UserDetailsBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public UserDetailsImpl build() {
            return new UserDetailsImpl(this);
        }
    }

}
