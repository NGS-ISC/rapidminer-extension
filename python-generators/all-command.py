import yaml

def parse_yaml(name, empty_if_not_exists=False):
    try:
        f = open(name)
        data = yaml.safe_load(f)
        f.close()
    except FileNotFoundError as e:
        if empty_if_not_exists:
            return {}
        raise e
    if not data and empty_if_not_exists:
        raise Exception
    return data

def save_yaml(name, data):
    f = open(name, 'w')
    yaml.dump(data, f)
    f.close()


def get_commands_data(log_commands, commands):
    for log_command in log_commands:
        if commands.get(log_command):
            continue



if __name__== '__main__':
    test_cut = '/home/user/Загрузки/rapidminer_test/yaml/test_cut.yaml'
    test_new = '/home/user/Загрузки/rapidminer_test/yaml/test_new.yaml'
    source = 'https://github.com/mothur/mothur/blob/088c67c6a1334d716a143d57bbd9e327efa146fa/source/commands/{command_name}command.cpp'
    log_commands = parse_yaml(test_cut)
    commands = parse_yaml(test_new, True)