/*
 * Copyright 2012 Mohan Singh.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.luc.filters;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public final class EmailFilter extends FilteringTokenFilter {
	
	
	
	private final CharTermAttribute termAttribute= addAttribute(CharTermAttribute.class);
	
	private final Pattern pattern=Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
	private Matcher matcher;
	
	public EmailFilter (boolean enablePositionIncreament , TokenStream in){
		
		super(enablePositionIncreament,in);
		
	}
	
	@Override
	public boolean accept() throws IOException{
		
		final String email=termAttribute.toString();
		
		matcher = pattern.matcher(email);	

		return(matcher.matches());	
		
		
	}

}
