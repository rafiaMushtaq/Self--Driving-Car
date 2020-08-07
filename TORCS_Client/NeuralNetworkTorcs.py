import pandas as pd
#read in data using pandas
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.callbacks import EarlyStopping
import numpy
train_df = pd.read_csv('StateDriveFile.csv',sep = ',', names=['Speed','AngleToTrackAxis','TrackPosition','Gear','RacePos', 'LateralSpeed','CurrentLapTime','Damage','DistanceFromStartLine','DistanceRaced','FuelLevel','LastLapTime','RPM','ZSpeed','Z','accel','steer','gear'])
train_y = train_df[['accel','steer','gear']]
train_y.head()

train_X = train_df.drop(columns=['accel','steer','gear'])
train_X.head()

#create model
model = Sequential()

#get number of columns in training data
n_cols = train_X.shape[1]

#add model layers
#model.add(Dense(19, activation='relu', input_shape=(n_cols,)))
#model.add(Dense(19, activation='relu'))
#model.add(Dense(3))
model.add(Dense(15, activation='relu', input_shape=(n_cols,)))
model.add(Dense(200, activation='relu'))
model.add(Dense(200, activation='relu'))
model.add(Dense(3))
#compile model using mse as a measure of model performance
model.compile(optimizer='adam', loss='mean_squared_error')

#set early stopping monitor so the model stops training when it won't improve anymore
early_stopping_monitor = EarlyStopping(patience=3)
#train model
model.fit(train_X, train_y, validation_split=0.2, epochs=30, callbacks=[early_stopping_monitor])

test_y_predictions = model.predict(train_X)
test_y_predictions

model.save("torcsModel.h5")

df=pd.DataFrame(test_y_predictions)
df.to_csv('predictions.csv', sep=',', encoding='utf-8', index=False)