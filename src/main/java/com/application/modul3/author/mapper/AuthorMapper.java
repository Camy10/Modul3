package com.application.modul3.author.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.author.Author;
import com.application.modul3.author.dto.AuthorCreateDTO;
import com.application.modul3.author.dto.AuthorDTO;

@Service
public class AuthorMapper {

	public AuthorDTO author2AuthorDTO(Author author) {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(author.getId());
		authorDTO.setName(author.getName());
		authorDTO.setBirthDate(author.getBirthDate());
		authorDTO.setDeathDate(author.getDeathDate());
		authorDTO.setGender(author.getGender());
		authorDTO.setNationality(author.getNationality());
		return authorDTO;
	}

	public Author authorDTO2Author(AuthorDTO authorDTO) {
		Author author = new Author();
		author.setId(authorDTO.getId());
		author.setName(author.getName());
		author.setBirthDate(authorDTO.getBirthDate());
		author.setDeathDate(authorDTO.getDeathDate());
		author.setGender(authorDTO.getGender());
		author.setNationality(authorDTO.getNationality());
		return author;
	}

	public List<AuthorDTO> authorList2AuthorListDTO(List<Author> list) {

		return list.stream().map(author -> author2AuthorDTO(author)).collect(Collectors.toList());
	}

	public List<Author> authorListDTO2AuthorList(List<AuthorDTO> authorListDTO) {
		return authorListDTO.stream().map(authorDTO -> authorDTO2Author(authorDTO)).collect(Collectors.toList());
	}

	public Author author2authorCreateDTO(Author author) {
		AuthorCreateDTO authorCreateDTO = new AuthorCreateDTO();
		author.setId(authorCreateDTO.getId());
		author.setName(authorCreateDTO.getName());
		author.setBirthDate(authorCreateDTO.getBirthDate());
		author.setDeathDate(authorCreateDTO.getDeathDate());
		author.setGender(author.getGender());
		author.setNationality(author.getNationality());
		
		return author;
	}
	public Author authorCreateDTO2Author(AuthorCreateDTO authorCreateDTO) {
		Author author = new Author();
		authorCreateDTO.setId(author.getId());
		authorCreateDTO.setName(author.getName());
		authorCreateDTO.setBirthDate(author.getBirthDate());
		authorCreateDTO.setDeathDate(author.getDeathDate());
		authorCreateDTO.setGender(author.getGender());
		authorCreateDTO.setNationality(author.getNationality());
		authorCreateDTO.setBooksId(author.getBookIDS());
		return author;
	}

}
