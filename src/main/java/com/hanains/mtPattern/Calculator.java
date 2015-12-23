package com.hanains.mtPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

	
	
	//곱셈 콜백
	// 이 방식은 곱셈과 덧셈 같은 사칙연산을 콜백 함수 내에 구현할 경우 반복되는 코드의 양이 많아진다.
	public Integer calcmultiply(String filepath) throws IOException{
		
		BufferedReaderCallback multiplyCallback = new BufferedReaderCallback() {
			
			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
				
				Integer multiply = 1;
				String line = null;
				while( (line = br.readLine()) != null ){
					multiply = multiply * Integer.parseInt(line);
				}
				
				return multiply;
			}
		};
		
		return fileReadTemplate(filepath, multiplyCallback);
	}
	
	
	public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback) throws IOException{
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(filePath));
			int ret = callback.doSomethingWithReader(br);
			return ret;
			
		} catch (IOException e) {
			// TODO: handle exception
			
			throw e;
		}finally {
			if(br != null){
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	//곱셈 콜백
	//사칙 연산 코드를 콜백 함수내에 구현 하지 않고 탬플릿 내에서 처리를 하도록 하면 반복되는 코드의 양이 줄어든다.
	public Integer calcMultiply(String filePath) throws IOException {
		
		LineCallback multiplyCallback = new LineCallback() {
			
			public Integer doSomethingWithLine(String line, Integer value) {
				// TODO Auto-generated method stub
				return value * Integer.valueOf(line);  // 이 코드만 추가가 된다.
			}
		};
		
		return lineReadTemplate(filePath, multiplyCallback, 1);
		
	}
	
	public Integer lineReadTemplate( String filePath, LineCallback callback, int initValue ) throws IOException{
		
		BufferedReader br = null;
		try {
			
			br = new BufferedReader(new FileReader(filePath));
			Integer res = initValue;
			String line = null;
			while( (line = br.readLine()) != null ){
				res = callback.doSomethingWithLine(line, res);
			}
			
			return res;
			
		} catch (IOException e) {
			// TODO: handle exception
			throw e;
		}finally {
			if(br != null){
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	
	}
	
	
}
