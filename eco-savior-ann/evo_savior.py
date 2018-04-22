#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Apr 21 23:39:57 2018

@author: hbhavsar
"""

# -*- coding: utf-8 -*-

# Importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Importing the dataset
dataset = pd.read_csv('lion_2017.csv')
X = dataset.iloc[:, 2: 12].values
y = dataset.iloc[:, 12].values

# Encoding categorical data
# Encoding the Independent Variable
#Country
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
#labelencoder_X_1 = LabelEncoder()
#X[:, 1] = labelencoder_X_1.fit_transform(X[:, 1])

#Gender
#labelencoder_X_2 = LabelEncoder()
#X[:, 2] = labelencoder_X_2.fit_transform(X[:, 2])

#Eliminate Dummy Variable
#onehotencoder = OneHotEncoder(categorical_features = [1])
#X = onehotencoder.fit_transform(X).toarray()
#X = X[:, 1:]

# Splitting the dataset into the Training set and Test set
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

# Feature Scaling
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.transform(X_test)


#Part - 2 ANN
#Import the Keras libraries and packages
import keras
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import Dropout

#Initialising the ANN
classifier = Sequential()

#Adding the input layer and the first hidden layer with dropout
classifier.add(Dense(units = 6, kernel_initializer='uniform', activation='relu', input_dim = 10))
#classifier.add(Dropout(0.1))

#Adding the second hidden layer
classifier.add(Dense(units = 6, kernel_initializer='uniform', activation='relu'))
#classifier.add(Dropout(0.1))

#Adding the Third hidden layer
classifier.add(Dense(units = 6, kernel_initializer='uniform', activation='relu'))

#Adding the Fourth hidden layer
classifier.add(Dense(units = 6, kernel_initializer='uniform', activation='relu'))

#Adding the ouput layer
classifier.add(Dense(units = 1, kernel_initializer='uniform', activation='sigmoid'))

#Compiling the ANN
#if binary out come => loss fun = 
#if not binary/classification out come => loss fun = 
classifier.compile(optimizer = 'adam', loss =  'binary_crossentropy', metrics = ['accuracy'])

#Fitting the ANN to the training Set
classifier.fit(X_train, y_train, batch_size = 10, epochs = 150)


# Predicting the Test set results
y_pred = classifier.predict(X_test)

y_pred = (y_pred > 0.5)

# Making the Confusion Matrix
from sklearn.metrics import confusion_matrix
cm = confusion_matrix(y_test, y_pred)

# Store model
# serialize model to JSON
model_json = model.to_json()
with open("evo-savior-model.json", "w") as json_file:
    json_file.write(model_json)
# serialize weights to HDF5
model.save_weights("evo-savior-model.h5")
print("Saved evo savior model to disk")





