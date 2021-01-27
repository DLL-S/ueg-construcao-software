package com.dlls.pecacerta.api.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dlls.pecacerta.api.utils.Error;

@ControllerAdvice
public class PecaCertaExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messages;

	private List<Error> buildErrorsList(BindingResult results) {
		List<Error> errors = new ArrayList<>();

		for(FieldError fieldError : results.getFieldErrors()) {
			String userMessage = messages.getMessage(fieldError, LocaleContextHolder.getLocale());
			String developerMessage = fieldError.toString();
			errors.add(new Error(userMessage, developerMessage));
		}

		return errors;
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.invalid-request", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Error> errors = buildErrorsList(ex.getBindingResult());

		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleAnyException(Exception ex, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.internal-server-error", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<?> handleEmptyResultDataAccessException(Exception ex, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.resource-not-found", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ DataIntegrityViolationException.class, ConstraintViolationException.class })
	public ResponseEntity<?> handleDataIntegrityViolationException(Exception ex, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.invalid-operation", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ FuncionarioNonexistentException.class })
	public ResponseEntity<?> handleFuncionarioNonexistentException(FuncionarioNonexistentException ex, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.funcionario-nonexistent", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ FuncionarioAlreadyExistsException.class })
	public ResponseEntity<?> handleFuncionarioAlreadyExistsException(FuncionarioAlreadyExistsException ex, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.funcionario-already-exists", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ ClienteNoneExistentException.class })
	public ResponseEntity<?> handleClienteNonexistentException(ClienteNoneExistentException ex, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.cliente-nonexistent", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ ClienteAlreadyExistsException.class })
	public ResponseEntity<?> handleClienteAlreadyExistsException(ClienteAlreadyExistsException ex, WebRequest request) {

		List<Error> errors = Arrays.asList(
				new Error(messages.getMessage("message.cliente-already-exists", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex))
			);

		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
