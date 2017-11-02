import re
import yaml

def getCommands(path):
	''' get mothur commands from logfile with keyphrase 'mothur > '. Return List type '''
	f = open(path, 'r')
	mothurCommands = []
	for line in f:
		if 'mothur > ' in line:
			tempo = line[9:].strip()
			if tempo:
				mothurCommands.append(tempo)
	mothurCommands.sort()
	f.close()
	return mothurCommands

def parse(commandsList):
	''' Return mothur commands and params to dict type '''
	command_struct = {}
	for command in commandsList:
		command_name, params_with_values = re.findall(r'^([a-zA-Z.]+?)[(]([a-zA-Z0-9=.,_\s-]*)[)]$', command).pop()
		params_list = {}
		for param_with_value in params_with_values.split(','):
			if not param_with_value:
				continue
			try:
				param_val_split = param_with_value.strip().split('=')
				if len(param_val_split) == 2:
					params_list[param_val_split[0].strip()] = param_val_split[1].strip()
			except Exception as e:
				raise e
		if not command_struct.get(command_name):
			command_struct[command_name] = []
		command_struct[command_name].append(params_list.copy())
	return command_struct

def save_yaml(name, data):
    f = open(name, 'w')
    yaml.dump(data, f)
    f.close()

if __name__== '__main__':
	mothurCommands = getCommands('/home/user/Загрузки/rapidminer_test/mothur.1494905879.logfile')
	save_yaml('/home/user/Загрузки/rapidminer_test/yaml/test.yaml', parse(mothurCommands))

	#^([a-zA-Z.]+?)\((([a-zA-Z]+?)\=([a-zA-Z.]+?)\,{0,1})+?\)$
	#^([a-zA-Z.]+?)\(([a-zA-Z0-9=., ]+?)\)$